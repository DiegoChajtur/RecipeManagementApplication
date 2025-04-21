#!/bin/bash

podman compose down &&
podman container prune -f &&
podman volume prune -f &&
podman compose build &&
podman compose up