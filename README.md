# bookclub

Website for Hacker Book Club

## Installation

Download from [Github](https://github.com/frankcash/bookclub).

Then run:

```
$ lein deps
```
Make sure you have [Postgresql](http://www.postgresql.org/).
## Running

```
$ lein ring server-headless
```


Alternatively:

```
$lein repl
```

```clojure
=> (use 'ring.adapter.jetty)
=> (use 'hello-world.core)
=> (run-jetty handler {:port 300})
```

## License

Copyright © 2015 Frank Cash

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
