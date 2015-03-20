Execute the change sets:
	mvn liquibase:update -Pdb2
Delete All:
	mvn liquibase:dropAll -Pdb2
Rollback:
mvn liquibase:rollback -Dliquibase.rollbackCount=1 -Pdb2

Reference:
http://www.liquibase.org/documentation/maven/
http://www.liquibase.org/documentation/changes/