//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() throws IOException {
    IO.println("Hello and welcome to Advent of Code 2025!");

    Day2 day2 = new Day2();
    day2.computeInvalidIDTotal2("src/day2-input.txt");
    IO.println(day2.getTotalSum());
}

