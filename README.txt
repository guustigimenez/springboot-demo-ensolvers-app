READ ME FOR MORE INFORMATION

##############################################
# ENGINES, TOOLS, NEEDED FOR DEV ENVIRONMENT #
##############################################

-Springboot-starter => v(2.7.1)
-Java => v(1.8) coreto SDK
-Spring web
-lombok
-postgreSQL
-JPA
-MAVEN
#####################################################
# ENGINES, TOOLS, NEEDED FOR PRODUCTION ENVIRONMENT #
#####################################################

TO EXCECUTE BACK-END YOU NEED TO HAVE INSTALLED JAVA TO BE ABLE TO EXECUTE NEXT COMMAND

root directory => /demo 
command to execute back-end => java -jar target/demo-0.0.1-SNAPSHOT.jar 

demo-0.0.1-SNAPSHOT.jar => its a compiled jar version with all dependencies needed to run springboot application on localhost 8080


#################################
#         DEPLOYMENT            #
#################################

As i didnt have the knowledge needed to be able tu create a script to run all applications at once I manage to deploy back-end in the next URL

https://postgresql-demo-database.herokuapp.com

##########
# ROUTES #
##########

https://postgresql-demo-database.herokuapp.com/user/login => POST METHOD FOR LOGIN IN
https://postgresql-demo-database.herokuapp.com/notes => POST METHOD FOR ADDING NOTES, PUT METHOD FOR EDITING NOTE, GET METHOD FOR GETTING ALL NOTES
https://postgresql-demo-database.herokuapp.com/notes/{id} => GET METHOD FOR RETRIEVING AN INDIVIDUAL NOTE
https://postgresql-demo-database.herokuapp.com/notes/filtered => GET METHOD FOR RETRIEVING NOTES BY CATEGORY
https://postgresql-demo-database.herokuapp.com/notes/archived => GET METHOD FOR RETRIEVING ALL ARCHIVED NOTES
https://postgresql-demo-database.herokuapp.com/notes/delete/{id} => DELETE METHOD FOR DELETING NOTE BY ID

IMPORTANT => IF YOU ARE RUNNING THE SERVER LOCALLY JUST CHANGE HTTPS TO HTTP AND BASE URL TO localhost:8080
