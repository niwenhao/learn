# Cloud Foundryを構成するコンポーネント
    
Application execution engine.

Scriptable CLI

## Routing

*   Router

## Authentication

*   OAuth2 Server

*   Login Server

## App lifecycle

*   Cloud controller - for  deployment

*   Diego Brain - cellを操作する。

*   nsync--[DesiredLRP]->BBS<-[ActualLRP]--Cell reps

## App storage and execution

*   Blobstore

    *   Application package

    *   Buildpacks

    *   Droplets

*   Diego Cell

    App executor and monitor

## Services

*   service brokers - locator

## Messaging

*   Consul

    Long lived data
    
*   BBS

    publish system resource status.

## Metrics and logging

*   metrics collector

*   loggregator
    
    App --[loggregator]-> User


