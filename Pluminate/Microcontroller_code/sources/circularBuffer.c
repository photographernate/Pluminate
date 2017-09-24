/*
*****************************************************************
*This file initializes two circular buffers TXbuffer(transmit) &
*RXbuffer(recieve)
* for use in lab_5 for ECE 631
*Author: Brandon Dunn
*Date: 28 Feb 2017
*Modified 13 March 2017
*****************************************************************
*/

//Include statements
#include "circularbuffer.h"

/*
*Function for Initalizing the circular buffers
*this function takes a buffer pointer
*this function returns nothing
*/
void InitBuffer(volatile commBuffer_t* comm)
{
  comm->head = 0;
  comm->tail = 0;
  comm->count = 0;
}

/*
*Function for putting a character in the circular buffer
*this function takes a buffer pointer and a char
*this function returns nothing
*/
void putChar(volatile commBuffer_t* comm, char ch)
{
  if(comm->count < MAXCOMMBUFFER)
  {
    comm->buffer[comm->head] = ch;
    comm->count++;
    comm->head = (comm->head + 1)%MAXCOMMBUFFER;
    return;
  }
  return;
}

/*
*Function for getting a character from the circular buffer
*this function takes a buffer pointer
*this function returns a char
*/
char getChar(volatile commBuffer_t* comm)
{
  if(comm->count > 0)
  {
    char temp = comm->buffer[comm->tail];
    comm->tail = (comm->tail + 1)%MAXCOMMBUFFER;
    comm->count--;
    return temp;
  }
  return NULL;
}

/*
*Function for putting a string in the circular buffer
*this function takes a buffer pointer and a string pointer
*this function returns nothing
*/
void putStr(volatile commBuffer_t* comm, char* str)
{
  uint32_t strLength = strlen(str);
  for (uint32_t i =0; i < strLength; i++) putChar(comm, str[i]);
}

/*
*Function for getting a string from the circular buffer
*this function takes a buffer pointer, Char pointer, and a uint32_t
*this function returns nothing
*/
void getStr(volatile commBuffer_t* comm, char* str, uint32_t len)
{
    int i= 0;
    for(i = 0; i < len -2 ; i++)
    {
      str[i] = getChar(comm);
    }
    str[i+1] = '0x00';
    getChar(comm);
}

/*
*Function for checking if a string is in the circular buffer
*this function takes a buffer pointer
*this function returns the length of the string if one is found
*/
uint32_t haveStr(volatile commBuffer_t* comm)
{
  uint32_t strLength = 0;

for(uint32_t i = 0; i < comm->count; i++)
  {
    char temp = comm->buffer[(i + comm->tail)% MAXCOMMBUFFER];
    strLength++;
    if(temp == '\n')
    {
      strLength++;
      return strLength;
    }
  }
  return 0;
}
