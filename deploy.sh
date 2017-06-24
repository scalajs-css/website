#!/bin/sh


#Handy script to deploy app to github pages(gh-pages)

# get comment
comment="$1"

rm -rf build

sbt clean

sbt web:prod

yarn install

npm run build


if [ "$comment" == "" ]; then
comment="push from CI"
echo "no comment specified to deploy, using default : $comment"
fi


ghPagesPath="/Users/chandrasekharkode/Desktop/Kode/Programming/scalaprojects/scalajs-css/scalajs-css.github.io"

projectPath=${ghPagesPath}

mkdir -p ${projectPath}/build

cp index.html ${projectPath}

cp -r build/ ${projectPath}/build/

cd ${ghPagesPath}

git add .

git commit -m "$comment"

git push