# Trains
try-catch with resourses
try (Scanner reader = new Scanner(System.in)) {
...
}
...
закрывает поток System.in после выхода из блока try, из-за чего больше ничего не возможно считать. Вместо неё используеться обычный try-catch
Scanner reader = new Scanner(System.in);
try {
...
}
...
