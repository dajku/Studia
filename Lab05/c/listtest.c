#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>
#include "list.h"

int main() {
  char command[20];
  bool cont = true;
  int r;
  int index;
  list l = malloc(sizeof(list_t));
  l->first = l->last = NULL;
  l->length = 0;
  while (cont) {
    printf("Command: ");
    scanf("%s", command);
    if (!strcmp(command, "pop")) {
      if (!is_empty(l)) {
        r = pop(l);
        printf("Result: %d\n", r);
      } else {
        printf("Error - stack is empty!\n");
      }
    }
    else if (!strcmp(command, "push")) {
      printf("Value: ");
      scanf("%d", &r);
      push(l, r);
      printf("Result: OK\n");
    }
    else if (!strcmp(command, "append")) {
      printf("Value: ");
      scanf("%d", &r);
      append(l, r);
      printf("Result: OK\n");
    }
    else if (!strcmp(command, "print")) {
      printf("Result: ");
      print(l);
    }
    else if (!strcmp(command, "get")){
      printf("Value: ");
      scanf("%d", &r);
      if (r >= 0 && r < length(l)){
        printf("Result: %d\n", get(l,r));
      }
      else{
        printf("Zły indeks\n");
      }
    }
    else if (!strcmp(command, "put")){
      printf("Index: ");
      scanf("%d", &index);
      if (index < length(l)){
        printf("Value: ");
        scanf("%d", &r);
        put(l, index, r);
        printf("Result: OK\n");
      }
      else{
        printf("Zły indeks\n");
      }
    }
    else if (!strcmp(command, "insert")){
      printf("Index: ");
      scanf("%d", &index);
      if (index <= length(l)){
        printf("Value: ");
        scanf("%d", &r);
        insert(l, index, r);
        printf("Result: OK\n");
      }
      else{
        printf("Zły indeks\n");

      }
    }
    else if (!strcmp(command, "delete")){
      printf("Index: ");
      scanf("%d", &index); 
      if (index < length(l)){
        delete(l, index);
        printf("Result: OK\n");
      }
      else{
        printf("Zły indeks\n");
      }
    }
    else if (!strcmp(command, "clean")){
      clean(l);
      printf("Result: OK\n");
    }
    else if (!strcmp(command, "length")) {
      r = length(l);
      printf("Result: %d\n", r);
    }
    else if (!strcmp(command, "exit")) {
      cont = false;
    }
    else
      printf("Unknown command!\n");
  }
  while (!is_empty(l))
    pop(l);
  free(l);

  return 0;
}
