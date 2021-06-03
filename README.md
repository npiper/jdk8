# Functional Programming examples - Java 8

## What is a functional Interface?

Interface with a single, abstract method.

Lambdas can only be assigned to functional Interfaces?

In the `java.util.function` package with the `@FunctionalInterface` annotation.

## Method References

Use `::` annotation - useful for Stream processing and is more readable / maintainable code.

```
System.out::println

X -> System.out.println(x)

//
String::compareToIgnoreCase
String::length
Math::max

ArrayList::new // Constructors
Person[]::new

```

## Change to Interfaces - Default methods

Use keyword `default`

On conflict:

 * Class vs Interface → Class always wins
 * Interface vs Interface -> Child overrides Parent

Can add static methods in Interfaces

See `Comparator.comparing`

```
public interface Hairy {

  /** Grows some hair.
   *
   */
  public void growHair();

  /** Gives our object a haircut.
   *
   */
  public void haircut();

  // Default method
  default String getColour()
  {
    return "black";
  }

}
```

## Consumers

![Consumer](./src/images/game.png)

Use up elements of the string, e.g. Printing

```
void accept(T t)
```

### Implementations

```
IntConsumer, LongConsumer,
DoubleConsumer,
BiConsumer<T,U>
```

## Predicates

![Consumer](./src/images/filter.png)

Test the stream elements, typically filters out elements of the list

Interface returns a boolean.

```
boolean test(T t)
```

## Suppliers

<img src="./src/images/duplicate.png" width="256px" height="256px">


Create an object, but only when we need it - adds to the stream / terminal operation

No arg, returns a single result.

```
T get()
```

## Function

![Consumer](./src/images/flow.png)

Transform elements e.g. T->R, used for Mapping map() methods

Single arg of type `T`, returns a Type `R` (Map).

```
R apply(T t)
```

## Comparator

<img src="./src/images/sort-ascending.png" width="256px" height="256px"/>

java.util.Comparator - used for Streams with an Order (e.g. Integer) - max, min

Can be used to avoid static inner Comparator classes and use `. stream().sorted(...)`

```
    List<Human> sortedHumans = humans.stream()
      .sorted(Comparator.comparing(Human::getName))
      .collect(Collectors.toList());
```

https://www.baeldung.com/java-8-sort-lambda

## Collector

![Consumer](./src/images/data-collection.png)

Collector --> Convert Stream results to List (Terminal)

Don't do anything stateful in parallel


```
    // Consumers - use up elements of the string, e.g. Printing
    // Predicates - test the stream elements, typically filters out elements of the list
    // Suppliers - create an object, but only when we need it - adds to the stream / terminal
    // operation
    // Function -
    // java.util.Comparator - used for Streams with an Order (e.g. Integer) - max, min
    // Collector --> Convert Stream results to List (Terminal)

    // Don't do anything stateful in Parallel
```


## Streams

### Stream Pipelines

![Consumer](./src/images/tasks.png)

#### Parallelizing Streams

```
parallelStream()
```

### Map / Reduce

Reduction operations.. are
Terminal operations that produce
one value from a stream.

(e.g. Sum, Count, Max, Min, Average, Mean,..)

![Consumer](./src/images/aggregate.png)



## Project Structure


## What to do next - Java programming




# References

[Spring Framework Essentials](http://shop.oreilly.com/product/0636920046837.do)

[Advanced Java Development](http://shop.oreilly.com/product/0636920051688.do)

## Modern Java Recipies Book

Source code:
https://github.com/kousen/java_upgrade
https://github.com/kousen/java_8_recipes


Materials:
http://www.kousenit.com/java8/
