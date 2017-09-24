/*
**************************************
*Main.c file for Pluminate project
*Authors: Brandon Dunn & Jacob Miles
*Date: 4/12/2017
*Version: 1.0
**************************************
*/

//Include statments for libraries and headers
#include "circularBuffer.h"
#include <string.h>
#include "msp430g2553.h"


//Declaring structs that will be used for program
volatile static struct commBuffer_t txBuffer;
volatile static struct commBuffer_t rxBuffer;

void main(void)
{
//    WDTCTL = WDTPW + WDTHOLD; // Stop WDT

    BCSCTL1 = CALBC1_12MHZ; // Set DCO to 16MHz
    DCOCTL = CALDCO_12MHZ; // Set DCO to 16MHz

    /* Configure hardware UART */
    P1SEL = BIT1 + BIT2 ; // P1.1 = RXD, P1.2=TXD
    P1SEL2 = BIT1 + BIT2 ; // P1.1 = RXD, P1.2=TXD
    UCA0CTL1 |= UCSSEL_2; // Use SMCLK
    UCA0BR0 = 138; // Set baud rate to 9600 with 16MHz clock
    UCA0BR1 = 0; // Set baud rate to 9600 with 16MHz clock
    UCA0MCTL = UCBRS0; // Modulation UCBRSx = 1
    UCA0CTL1 &= ~UCSWRST; // Initialize USCI state machine
    IE2 |= UCA0RXIE; // Enable USCI_A0 RX interrupt
    IE2 |= UCA0TXIE; //Enable USCI_A) TX intterupt
    __bis_SR_register(LPM0_bits + GIE); // Enter LPM0, interrupts enabled

    //Initialize buffers
    InitBuffer(&txBuffer);
    InitBuffer(&rxBuffer);

    //Initialize string
    char* newStr;

    //Main loop
    While(1)
    {
      int strLength = haveStr(&rxBuffer);
      if(strLength)
      {
        getStr(&rxBuffer, newStr, strLength);
        putStr(&txBuffer, newStr);
      }
    }
}

//Receive buffer interrupt handler
#pragma vector = USCIAB0RX_VECTOR
__interrupt void USCI0RX_ISR(void)
{
    static unsigned char data;
//    if (USCI_A0 & (1<<0)!= 0)
        data = UCA0RXBUF;
        putChar(&rxBuffer, data);
}

//Transmit buffer interrupt handler
#pragma vector = USCIAB0TX_VECTOR
__interrupt void USCI0TX_ISR(void)
{
  if(txBuffer->count == 0);
  else UCA0TXBUF = getChar(&txBuffer);
}
