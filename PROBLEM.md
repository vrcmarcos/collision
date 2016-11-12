# Fraud Problem

A card company has many customers and needs to deal with lots of frauds everyday. One way for fraud detection is dealing with collision networks.

A collision is simple: if some customer A provides the same information that a customer B provided in registration, we say A and B have a collision. For this exercise, a network of collisions is defined as a connected graph where each edge represents a collision between two nodes.

For instance, say A and B have a collision and B and C also have a collision. Then, A B and C belong to a collision network.

We are interested in knowing if two nodes belong to the same collision network, so the exercise is divided in two:

## First step

Your program should read from a file of collisions and provide a function that answers if two nodes belong to the same collision network. The file is formatted as follows: each line represents a collision. In each line, we have  two node ids separated by a single space.

## Second step

Your program should be able to handle two types of operations now:

- Add new collision between two nodes;
- Answer if two nodes belong to the same collision network.

## Third step

Implement a RESTful web server with endpoints for each of the operations from second step.

Remember that the number of customers may be large, so your solution must be efficient.

## Example

Consider a graph with the following collisions between nodes:

(1, 2)
(2, 3)
(1, 4)
(5, 6)
(6, 7)

In this case, there are two collision networks: (1, 2, 3, 4) and (5, 6, 7).

