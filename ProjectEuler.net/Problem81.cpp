/*
 
 PE Problem #81:
 
 In the 5 by 5 matrix below, the minimal path sum from the top left to the bottom right,
 by only moving to the right and down, is indicated in bold red and is equal to 2427.
 
 Find the minimal path sum, in matrix.txt (right click and "Save Link/Target As..."),
 a 31K text file containing a 80 by 80 matrix, from the top left to the bottom right
 by only moving right and down.
 
 */

#include <iostream>
#include <fstream>
#include <cstdlib>
#include <sstream>
#include <algorithm>

using namespace std;

int main(){
    
    int array[80][80];
    int sums[80][80];
    ifstream in_file("p081_matrix.txt");
    
    
    // parse and add to matrix
    int outer_index = 0;
    while (true){
        
        string s;
        getline(in_file, s);
        if (in_file.fail()){
            break;
        }
        stringstream ss(s);
        for (int i = 0; i < 80; i++){
            int x;
            ss >> x;
            if (ss.peek() == ',') ss.ignore();
            array[outer_index][i] = x;
           
        }
        outer_index++;
    }
    
    //initialize top row and left column of matrix
    sums[0][0] = array[0][0];
    for (int i = 1; i < 80; i++){
        sums[0][i] = sums[0][i-1] + array[0][i];
        sums[i][0] = sums[i-1][0] + array[i][0];
    }
    
    for (int i = 1; i < 80; i++){
        for (int j = 1; j < 80; j++){
            sums[i][j] = min(sums[i-1][j], sums[i][j-1]) + array[i][j];
        }
    }
    cout << "Answer: " << sums[79][79] << endl;
    in_file.close();
    return 0;
}

// Answer: 427337
// General strategy: use dynamic programming with min function. Fairly simple!
