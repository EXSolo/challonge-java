# challonge-java

[![Build Status](https://travis-ci.org/stefangeyer/challonge-java.svg?branch=master)](https://travis-ci.org/stefangeyer/challonge-java) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.exsoloscript.challonge/challonge-java/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.exsoloscript.challonge/challonge-java)

Java binding for the [CHALLONGE! REST Api](http://api.challonge.com/v1) using [Guice](https://github.com/google/guice) and [Gson](https://github.com/google/gson) internally and [Retrofit2](http://square.github.io/retrofit/) to bind the HTTP calls.

Released under the MIT license.

## gradle

```groovy
compile group: 'com.exsoloscript.challonge', name: 'challonge-java', version: '1.0.1'
```

## maven

```xml
<dependency>
    <groupId>com.exsoloscript.challonge</groupId>
    <artifactId>challonge-java</artifactId>
    <version>1.0.2</version>
</dependency>
```

## usage

In order to use this library for the Challonge! REST API, you need instantiate the `ChallongeApi`
class, which asks you for your Challonge! user name and API key (which you can get [here](https://challonge.com/settings/developer)).

```java
ChallongeApi api = Challonge.getFor(USERNAME, API_KEY);
```

In order to perform actions, you need to access the related handlers. 
There are handlers for tournaments, participants, matches and attachments.

### handlers

Each handler covers one base functionality of the Challonge! Api.
For more information view the handler's JavaDoc.

```java
api.tournaments().getTournament(...)
api.participants().getParticipants(...)
api.matches().updateMatch(...)
api.attachments().createAttachment(...)
```

**These handlers provide calls which need to be executed in order to work with the result.**  
Check out the chapter `calls` for more information.

### calls

Each action returns a call, that needs to be executed before the result can be used.
A call can be executed synchronous and asynchronously.

```java
Tournament t = api.tournaments().getTournament("tournament url or id here", false, false).sync();

api.tournaments().getTournament("tournament url or id here", false, false).async((tournament) -> {
    // request was successful
}, (throwable) -> {
    // something went wrong
});
```

### queries

In order to create or update elements using this library, you need to use queries.
Queries map all the parameters that can be sent in the request. All queries use the builder pattern
to insure easy instantiation. The following query would be used to create a tournament.

```java
TournamentQuery query = TournamentQuery.builder()
    .name("TournamentName")
    .url("tournamenturl")
    .build();
    
api.tournaments().createTournament(query).sync();
```
