# LevelsBeyond

Tested in MacBook.

* Back-End
1. Requirements
  a. JEE 2018-09
  b. Jaxrs-ri 2.27
  c. Apache-Tomcat 9.0.13
2. File
  a. api.war - build, src, WebContent.
3. Instruction
  a. Configure Apache-Tomcat for web server.
  b. Install (import) api.war to eclipse.
  c. Make sure web server includes api project in eclipse.
  d. URL depends on web server setup. I setup with 8080 port.
  e. CRUD operations.
    1. Get all notes: curl -i -H "Content-Type: application/json" -X GET http://localhost:8080/api/notes
    2. Get an existing note: curl -i -H "Content-Type: application/json" -X GET http://localhost:8080/api/notes/1
    3. Get notes by searching parameter: curl -i -H "Content-Type: application/json" -X GET http://localhost/api/notes?query=milk
    4. Create a new note: curl -i -H "Content-Type: application/json" -X POST -d '{"body" : "Pick up milk!"}' http://localhost:8080/api/notes
    5. Update an existing note: curl -i -H "Content-Type: application/json" -X PUT -d '{"body" : "updated another Pick up milk!"}' http://localhost:8080/api/notes/3
    6. Delete an existing note: curl -i -H "Content-Type: application/json" -X DELETE  http://localhost:8080/ai/notes/3
    7. Returning empty means empty notes or none existing id.

* Front-End
1. My web server - MAMP.
2. AngularJS.
3. There are two versions - LevelsBeyond and LevelsBeyond2.
  a. LevelsBeyond - $http.get('https://api.github.com/repos/angular/angular/issues').
     This doesn't return all 7 days previous issues. Just first page.
  b. LevelsBeyond2 - $http.get('https://api.github.com/repos/angular/angular/issues?page='+page).
     This returns all 7 days previous issues.
4. Instruction
  a. It depends on web server configuration. I setup with 8888 port.
  b. http://localhost:8888/LevelsBeyond/ for first version
  c. http://localhost:8888/LevelsBeyond2/ for second version.
  d. Returning simple html table format.
