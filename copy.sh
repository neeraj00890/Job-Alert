#!/bin/sh

cp  -r ./job-alert-ui/dist/job-alert-ui/* ./Job_Alert/src/main/resources/static/
cp  -r ./job-alert-ui/dist/job-alert-ui/* ./Job_Alert/target/classes/static/
echo "Done!"
