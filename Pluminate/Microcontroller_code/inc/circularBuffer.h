#ifndef CIRCULAR_BUFFER_H
#define CIRCULAR_BUFFER_H

#define MAXCOMMBUFFER 2048
#include "stm32f4xx.h"
#include "string.h"
typedef struct _commBuffer_t {
	uint32_t volatile head;
	uint32_t volatile tail;
	uint32_t volatile count;
	char volatile buffer[MAXCOMMBUFFER];

} commBuffer_t;

//Initializes the struct commBuffer_t to zero
void InitBuffer(volatile commBuffer_t* comm);

//Test if a complete string is in buffer delimiter is \n
uint32_t haveStr(volatile commBuffer_t* comm);

//Put character in buffer and update head
void putChar(volatile commBuffer_t* comm, char ch);

//Get character from buffer and update tail;
char getChar(volatile commBuffer_t* comm);

//put C string into buffer
void putStr(volatile commBuffer_t* comm, char* str);

//get C string from buffer
void getStr(volatile commBuffer_t* comm, char* str, uint32_t len);

#endif
