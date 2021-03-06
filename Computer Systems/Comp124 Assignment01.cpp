// Comp124 Assignment01.cpp : Defines the entry point for the console application.
//
// Thomas Coupe, 201241037, T.Coupe@student.liverpool.ac.uk
#include "stdafx.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
	int myarray[6];
	char module1[] = "Enter module %d mark: ";
	char modulenum[] = "%d";
	char printfails[] = "Modules Failed = %d\n";
	char printpasses[] = "Modules Passed = %d\n";
	int passedModules = 0;
	int failedModules = 0;
	int counter = 1;
	int adder = 0;

	_asm {

	start_loop: //creating the start of the loop
		lea eax, counter
		push[eax]
		lea eax, module1 //loads the address of module1 into the eax
		push eax //puts the eax into the stack
		call printf //prints the combined number and format
		add esp, 8 //gets rid of the 8 bytes you just put into the stack.

		lea eax, myarray //loads myarray into the eax
		add eax, adder
		push eax //puts eax into the stack
		lea ebx, modulenum //loads modulenum into the ebx
		push ebx //puts ebx into the stack
		call scanf //scanf takes user input
		add esp, 8 //again removing the last 8 bytes that were just put into the stack

		lea eax, myarray //moving myarray into the eax
		add eax, adder
		cmp[eax], 0 //comparing the eax with 0
		jl start_loop //restarts loop if user input is less than zero
		cmp[eax], 100 //comparing the eax with 100
		jg start_loop //restarts loop if user input is greater than 100

		add adder, 4
		add counter, 1 //adds one to counter if user input was between 0 - 100
		cmp counter, 7 //compares the current value of counter with 7 and stops looping if counter = 7
		jl start_loop

		mov counter, 0
		mov adder, 0

	comparing:
		cmp counter, 24
		je finished // if the condition is met it will jump to finished
		lea eax, myarray //moving myarray into the eax again
		add eax, counter
		add counter, 4 //adds 4 to counter
		cmp[eax], 40 // comparing the eax with 40
		jl failed //if module mark is less than 40 it will increase failedModules by one
		add passedModules, 1 //if module mark was over 40 it adds 1 to passed modules
		jmp comparing

	failed :
		add failedModules, 1 //adds 1 to failedModules
		jmp comparing

	finished :
		lea eax, failedModules //loads the address of failedModules into the eax
		push[eax] //pushes failedModules to the top of the stack
		lea eax, printfails 
		push eax
		call printf // prints the value of printfails
		add esp, 8
		lea eax, passedModules
		push[eax]
		lea eax, printpasses //prints the value of printpasses
		push eax
		call printf
		add esp, 8

		lea eax, modulenum
		push eax
		call scanf
		add esp, 8
	}
}