#include<string.h>
#include<stdio.h>
#include<iostream>
using namespace std;

class strSolution {
public:
	//strcpy function
	int myStrcpy(char* dest, char* src) {
		int len = 0;
		while (*src != '\0') {
			*(dest++) = *(src++);
			len++;
		}
		*dest = '\0';
		return len;
	}

	//replace all the space in the string to "%20"
	void ReplaceFun(char* str, int length) {
		//firstly count the space
		int count = 0;
		for (int i = 0; i < length; i++)
			if (str[i] == ' ')
				count++;
		int newlength = length + 2 * count;
		str[newlength] = '\0';
		for (int i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[newlength - 1] = '0';
				str[newlength - 2] = '2';
				str[newlength - 3] = '&';
				newlength -= 3;
			}
			else {
				str[newlength - 1] = str[i];
				newlength--;
			}
		}
	}
};


