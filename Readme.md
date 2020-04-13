# Scrum Scheduler

In the project directory, you can build:

`mvn clean package`

and run:

`java -jar target/scrum-0.0.1-SNAPSHOT.jar`

Runs the app in the development mode.<br />
[http://localhost:8080](http://localhost:8080).


## API endpoints

All available endpoints.

### Developer

POST /developers<br />
```
{
	"name": "developers name"
}
```

GET  /developers<br />
GET  /developers/{id}<br />
PUT  /developers/{id}<br />

### Stories

POST /stories<br />
```
{
    "title": "story 4",
    "description": "story 4",
    "status": "ESTIMATED",
    "storyPoints": 7
}
```
GET  /stories<br />
GET  /stories/{id}<br />
PUT  /stories/{id}<br />

### Bugs
POST /bugs<br />
```
{
    "title": "story 4",
    "description": "story 4"
}
```
GET  /bugs<br />
GET  /bugs/{id}<br />
PUT  /bugs/{id}<br />

## Notes

Some test data gets initialized during start up.

No Hibernate? Yes, because of the demo purpose. Configuring of the mappings between the entities takes too much time.

Just use test on the main logic like the builders.

Use builders to separate the logic from the value classes.

Schedule API not really Rest conform. Get schedule is not idempotent.

Stories with points greater 10 could not be scheduled.

