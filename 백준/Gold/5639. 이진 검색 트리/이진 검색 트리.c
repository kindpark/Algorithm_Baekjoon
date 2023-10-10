#include <stdio.h>
#include <stdlib.h>

typedef struct node {
	int key;
	struct node* left;
	struct node* right;
}node;

typedef struct tree {
	node* root;
}tree;

void insert(tree* t, int data) {
	node* newNode = (node*)malloc(sizeof(node));
	newNode->key = data;
	newNode->left = NULL;
	newNode->right = NULL;

	if (t->root == NULL) {
		t->root = newNode;
	}
	else {
		node* cur = t->root;
		node* parents = NULL;
		while (cur != NULL) {
			parents = cur;
			if (cur->key == data) {
				return;
			}
			if (cur->key < data) {
				cur = cur->right;
			}
			else {
				cur = cur->left;
			}
		}
		if (parents->key < data) 
			parents->right = newNode;
		else
			parents->left = newNode;
	}
}
void display(node* root){
	if (root != NULL) {
		display(root->left);
		display(root->right);
		printf("%d\n", root->key);
	}
}
void delete(tree* tree, int data) {
	//단말노드 삭제
	node* cur = tree->root;
	node* parents = NULL;
	node* child = NULL;
	while (cur != NULL && cur->key != data) {
		parents = cur;
		if (data < cur->key) {
			cur = cur->left;
		}
		else {
			cur = cur->right;
		}
	}
	if (cur == NULL) {
		return;
	}
	if (cur->left == NULL && cur->right == NULL) {
		if (cur != tree->root) {
			if (parents->left == cur) {
				parents->left = NULL;
			}
			else {
				parents->right = NULL;
			}
		}
		else {
			tree->root = NULL;
		}
		free(cur);
	}
	//자식이 하나
	else if (cur->left == NULL || cur->right == NULL) {
		if (cur->left == NULL) {//부모 왼쪽 부분에 삭제된 트리의 자식 노드를 연결
			 child = cur->right;
		}
		else {// 오른쪽에 동일하게
			child = cur->left;
		}
		if (cur != tree->root) {
			if (cur == parents->left) {
				parents->left = child;
			}
			else {
				parents->right = child;
			}
		}
		else {
			tree->root = child;
		}
		free(cur);
	}
	//자식이 둘
	else {
		child = cur->right;
		while (child->left != NULL) {
			child = child->left;
		}
		int k = child->key;
		delete(tree, child->key);
		cur->key = k;
	}
}
int main() {
	tree tree;
	tree.root = NULL;
	int n;
	for (int i = 1; i < 10001; i++) {
		scanf("%d", &n);
		insert(&tree, n);
	}
	display(tree.root);
}