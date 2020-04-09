#include <ctype.h>
#include <stdlib.h>
#include "isogram.h"

bool is_isogram(const char phrase[])
{
    if (phrase == NULL)
    {
        return false;
    }

    // lettersFound[i] = 1 if the ith letter of the alphabet
    // has already been found in phrase, 0 otherwise.
    int lettersFound[26] = {0};
    const char *c = phrase;
    while (*c != '\0')
    {
        if (isalpha(*c))
        {
            int i = tolower(*c) - 'a';
            if (lettersFound[i] != 0)
            {
                return false;
            }
            lettersFound[i] = 1;
        }
        c++;   
    }

    return true;
}