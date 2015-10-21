/*

RECTANGULAR LOVE

Write a function to find the rectangular intersection of two given love rectangles.

As with the example above, love rectangles are always "straight" and never "diagonal."
 More rigorously: each side is parallel with either the x-axis or the y-axis.

 */

#include <cstdlib>
#include <algorithm>

using namespace std;

struct Rectangle{
 	int x; // coordinates of bottom left point
 	int y;
 	int width;
 	int height;
};

Rectangle intersect(Rectangle r1, Rectangle r2){

	// find the left and right bounds of the intersection
	int xleft = max(r1.x, r2.x);
	int xright = min(r1.x + r1.width, r2.x + r2.width);

	if (xleft >= xright){
		return NULL;
	}

	// find the top and bottom boundaries of the intersection
	int ytop = min(r1.y + r1.height, r2.y + r2.height);
	int ybottom = max(r1.y, r2.y);

	if (ybottom >= ytop){
		return NULL;
	}

	Rectangle new_rect;
	new_rect.x = xleft;
	new_rect.y = ybottom;
	new_rect.width = xright - xleft;
	new_rect.height = ytop - ybottom;

	return new_rect;

}