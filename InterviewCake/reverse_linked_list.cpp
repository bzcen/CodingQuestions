/*

Reverse Linked List

Write a function to reverse a linked list in place.

*/

Node* reverse(Node* head){
	if (head == NULL) return false;
	if (head -> next == NULL) return false;

	Node* last = head;
	while (last -> next != NULL){
		last = last -> next;
	}
	Node* mark = last;
	while (head != mark){
		last -> next = head;
		last = last -> next;
		head = head->next;
		last -> next = NULL;
	}
	return head;
}
// runtime of O(n)