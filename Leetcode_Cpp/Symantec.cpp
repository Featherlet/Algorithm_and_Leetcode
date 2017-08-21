#include<string.h>
#include<stdio.h>
#include<iostream>
using namespace std;

int myStrcpy(char* dest, char* src) {
	int count = 0;
	char* old = src;
	int len = 0;
	while (*old != '\0') {
		old++;
		len++;
	}
	len++;
	dest = (char*)malloc(sizeof(char) * len);
	old = src;
	char* n = dest;
	while (*old != '\0') {
		*(n++) = *(old++);
	}
	*n = '\0';
	return len - 1;
}
