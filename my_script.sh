#!/usr/bin/env bash

# For dry run, use the --dry flag e.g.
# my_script.sh --dry

ktcodeshift "$@"  --transform hello.transform.kts ~/path/to/code/**/*.kt
