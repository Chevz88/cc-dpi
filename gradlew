#!/usr/bin/env sh
#
# Gradle wrapper script for Unix systems
#
DIR="$(cd "$(dirname "$0")" && pwd)"
exec "$DIR/gradle/wrapper/gradle-wrapper.jar" "$@"
