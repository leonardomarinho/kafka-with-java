compile:
	@ echo compiling
	@ mvn compile

test: compile
	@ echo testing
	@ mvn test

package: test
	@ echo packaging
	@ mvn -DskipTests package

run: package
	@ echo running
	@ docker-compose up

deploy: package
	@ echo deploying
	@ docker-compose up -d