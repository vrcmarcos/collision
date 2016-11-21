# Collision

[![Build Status](https://travis-ci.org/vrcmarcos/collision.svg?branch=master)](https://travis-ci.org/vrcmarcos/collision) [![Coverage Status](https://coveralls.io/repos/github/vrcmarcos/collision/badge.svg?branch=master)](https://coveralls.io/github/vrcmarcos/collision?branch=master)

A [Clojure](http://clojure.org/) project that solves the [fraud problem](https://github.com/vrcmarcos/collision/blob/master/PROBLEM.md).

## WebServer

The solutions is hosted on Heroku. You can see it live by clicking [on this link](https://powerful-fjord-35264.herokuapp.com/).

## Endpoints

- `GET "/"`: Shows the current networks list

	```bash
    curl -X GET "https://powerful-fjord-35264.herokuapp.com/"
    ```
- `PUT "/" [collision "node1 node2"]`: Add a new collision to the network list

	```bash
    curl -X PUT -F "collision=100 20" "https://powerful-fjord-35264.herokuapp.com/"
    ```
- `GET "/same_network?node1={node_1}&node2={node_2}"`: Shows if the `{node_1}` belongs to the same networks that `{node_2}` belongs

	```bash
	curl -X GET "https://powerful-fjord-35264.herokuapp.com/same_network?node1=13&node2=89"
    ```

## Algorithm Complexity

You can check the actual algorithms complexity on the below list:

- Add new collision: O(n^2)
- Check if two nodes belongs to the same collision: O(n^2)

## Environment setup

### MacOS

```bash
brew install leiningen
```

## Running

A `Makefile` gives you the following tasks:

- run_server: Run the web server (Default port: 3000)
- run_test: Run unit tests

## Frameworks/Libraries used:

- [Luminus Web Framework](http://www.luminusweb.net/)