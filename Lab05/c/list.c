#include <stdio.h>
#include <stdlib.h>
#include "list.h"

bool is_empty(list l) {
  return l->first == NULL;
}
int pop(list l) {
  node_ptr n = l->first;
  int e = n->elem;
  l->first = l->first->next;
  if (l->first == NULL)  // last element
    l->last = NULL;
  l->length = l->length - 1;
  free(n);
  return e;
}
void push(list l, int e) {
  node_ptr n = malloc(sizeof(node));
  n->elem = e;
  n->next = l->first;
  l->first = n;
  if (l->last == NULL)  // first element
    l->last = n;
  l->length = l->length + 1;
}
void append(list l, int e) {
  node_ptr n = malloc(sizeof(node));
  n->elem = e;
  n->next = NULL;
  if (l->first == NULL)  // first element
    l->first = n;
  else
    l->last->next = n;
  l->last = n;
  l->length = l->length + 1;
}

// FUNKCJE Z ZADANIA

int get(list l, int i){
  node_ptr aktualny_node = l->first;
  int aktualny_index = 0;

  while (aktualny_index < i){
    aktualny_node = aktualny_node->next;
    aktualny_index = aktualny_index + 1;
  }

  return aktualny_node->elem;
}

void put(list l, int i, int e){
  node_ptr aktualny_node = l->first;
  int aktualny_index = 0;

  while (aktualny_index < i){
    aktualny_index = aktualny_index + 1;
    aktualny_node = aktualny_node->next;
  }

  aktualny_node->elem = e;
}

void insert(list l, int i, int e){
  node_ptr aktualny_node = l->first;
  node_ptr nowy_node = malloc(sizeof(node));
  
  if (i == 0) {
    push(l, e);
  }
  
  else if(i == length(l)) {
    append(l, e);
  }
  else{
    // iterujemy od 2 elementu (index 1) do przedostatniego (i-1)
    for (int j = 1; j < i; j++){
      aktualny_node = aktualny_node->next;
    }
    nowy_node->elem = e;
    nowy_node->next = aktualny_node->next;
    aktualny_node->next = nowy_node;
    l->length = l->length + 1;
  }
}

void delete(list l, int i){

  node_ptr tmp;
  node_ptr prev_node;

  if (i == 0){
    if (l->first = l->last) {
      tmp = l->first;
      l->first = NULL;
      l->last = NULL;
      free(tmp);
      l->length = 0;
    }
    else{
      tmp = l->first;
      l->first = l->first->next;
      l->length = l->length - 1;
      free(tmp);
    }
  }
  else{
    prev_node = l->first;

    for (int j = 1; j < i; j++){
      prev_node = prev_node->next;
    }
    tmp = prev_node->next;
    prev_node->next = tmp->next;
    free(tmp);
    l->length = l->length - 1;
    if ( prev_node->next == NULL){
      l->last = prev_node;
    }
  }

}

void clean(list l){
  node_ptr aktualny_node = l->first;
  node_ptr tmp;

  while (aktualny_node != NULL) {
    tmp = aktualny_node;
    aktualny_node = aktualny_node->next;
    free(tmp);
  }
  l->first = NULL;
  l->last = NULL;
  l->length = 0;
}



void print(list l) {
  node_ptr n = l->first;
  while (n != NULL) {
    printf(" %d", n->elem);
    n = n->next;
  }
  printf(" ( %d )\n", length(l));
}
int length(list l) {
  return l->length;
}

