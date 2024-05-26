This framework has developed on BDD (cucumber) with integration of Serenity reports.

The logs are configured for high level. It will prints each scenario run details like duration, status, failure cause/error. Even, we can push the above all run scenario details into the Database.

The serenity reports are good for UAT and RestAPI's automation. Thses Report are very easy to understand.
We can share the report link to any business person, but must be run through your Jenkins pipe line.

Suggesstion:
--> Make a separate folder for reports and Create a sub-folder with time-stamp when run has happened in the Jenkins pipe line.
--> So, for that use perl scripts to create a folder and move the entire serenity folder into the sub-folder.
