#!/usr/bin/env bash

# For dry run, use the --dry flag e.g.
# my_script.sh --dry

ktcodeshift "$@"  --transform hello.transform.kts ~/myCode/pleo/commsgateway/pleo-commsgateway-requestmodels/src/main/kotlin/io/pleo/commsgateway/requestmodels/requests/**/SendExampleNotificationRequest.kt
