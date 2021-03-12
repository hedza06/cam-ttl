## Camunda (History) Time To Live
This project demonstrates usage of TTL (Time To Live) mechanism for removing historic
data from database (permanently).

When used intensively, the process engine can produce a huge amount of historic data. History Cleanup is a feature that 
removes this data based on configurable time-to-live settings.

It deletes:
- Historic process instances plus all related historic data (e.g., historic variable instances, historic task instances, historic instance permissions, all comments and attachments related to them, etc.)
- Historic decision instances plus all related historic data (i.e., historic decision input and output instances)
- Historic case instances plus all related historic data (e.g., historic variable instances, historic task instances, etc.)
- Historic batches plus all related historic data (historic incidents and job logs)

History Time To Live (TTL) defines how long historic data shall remain in the database before it is cleaned up.
- Process, Case and Decision Instances: TTL can be defined in the XML file of the corresponding definition. This value 
can furthermore be changed after deployment via Java and REST API.
- Batches: TTL can be defined in the process engine configuration.

### Instance Removal Time
Removal Time is the time after which an instance shall be removed. It is computed as removal time = base time + TTL. 
Base time is configurable and can be either the start or the end time of an instance.

### Cleanup Strategies
In order to use history cleanup, you must decide for one of the two avialable history cleanup strategies: 
Removal-Time-based or End-Time-based strategy. In this demo I'm using end-time-based strategy.

The end-time-based cleanup strategy deletes data whose end time plus TTL has expired. In contrast to the removal-time 
strategy, this is computed whenever history cleanup is performed. The main strength of end-time-based strategy
is that you can configure cleanup intervals that can be controlled in three ways:  
- Cleanup Window: Determines a time frame in which history cleanup runs. This allows to use the job executor?s resources only when there is little load on your system (e.g. at night time or weekends). Default value: No cleanup window is defined. That means that history cleanup is not performed automatically.
- Batch Size: Determines how many instances are cleaned up in one cleanup transaction. Default: 500.
- Degree of Parallelism: Determines how many cleanup jobs can run in parallel. Default: 1 (no parallel execution).

### Cleanup configuration (YAML)
Here is the example of history cleanup configuration:  
```
camunda:
  bpm:
    ...
    # TTL specific properties
    generic-properties:
      properties:
        historyCleanupStrategy: endTimeBased
        fridayHistoryCleanupBatchWindowStartTime: "21:00"
        fridayHistoryCleanupBatchWindowEndTime: "23:00"
        historyCleanupBatchSize: 300
```
Other config parameters you can find on the following link: 
https://docs.camunda.org/manual/7.10/reference/deployment-descriptors/tags/process-engine/#history-cleanup-configuration-parameters

### Author
Heril Muratović  
Software Engineer  

Mobile: +38269657962  
E-mail: hedzaprog@gmail.com  
Skype: hedza06  
Twitter: hedzakirk  
LinkedIn: https://www.linkedin.com/in/heril-muratovi%C4%87-021097132/  
StackOverflow: https://stackoverflow.com/users/4078505/heril-muratovic 
