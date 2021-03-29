# Generic Expression Parser
>Был написан и успешно сдан в рамках университетского курса "Парадигмы программирования"
### Позволяет строить выражения вида:
```
  new Subtract<Integer>(
      new Multiply<Integer>(
              new Const<Integer>(new CheckedInt(2)),
              new Variable<Integer>("x")
      ),
      new Const<Integer>(new CheckedInt(2))
  )
```
Такое выражение является экземпляром класса BinaryOperation. У него есть метод toString(), который выдает запись выражения в полноскобочной форме, toMiniString(),
который выдает запись выражения без лишних скобок и метод evaluate(x, y, z), 
который позволяет посчитать значение выражения от 3х переменных в заданном пользователем типе
### Parser:
Умеет строить выражание по записи вида: 2 * (x + 1) - y, производя вычисления в заданном пользователем типе
```
new ExpressionParser<Integer>(CheckedInt::parse).parse("2 * (x + 1) - y")
```
### GenericTabulator:
Возвращает таблицу значений функции по 3-м переменным. Аргументы - режим вычислений(String), функция(String), диапазоны переменных(int)
