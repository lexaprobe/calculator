#!/bin/zsh

gradle test --console=rich 2>&1 | sed '/\* What went wrong:/,/Run with --scan/d; s/FAILURE: Build failed with an exception.//'