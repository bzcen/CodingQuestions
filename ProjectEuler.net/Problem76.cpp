/*

PE Problem #76

It is possible to write five as a sum in exactly six different ways:

4 + 1
3 + 2
3 + 1 + 1
2 + 2 + 1
2 + 1 + 1 + 1
1 + 1 + 1 + 1 + 1

How many different ways can one hundred be written as a sum of at least two positive integers?

*/
#include <cstdlib>
#include <iostream>

using namespace std;

int summation(int x, int subtract);

int main(){
    int answer = summation(100, 99);
    cout << "Answer: " << answer << endl;
    return 0;
}

int summation(int x, int subtract){
    if (x == 0){
        return 1;
    }
    if (x < 0){
        return 0;
    }
    
    int sum = 0;
    for (int i = 1; i <= subtract; i++){
        sum += summation(x - i, i);
    }
    return sum;
}

// Strategy: basic recursive method, pretty simple
// Answer: 190569291
