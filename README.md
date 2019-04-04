This project can be used as a starting point for a SpringBoot Hazelcast
client such as a loader that performs a task and exits.  It creates a single
HazelcastInstance using HazelcastClient.newInstance() so it can be configured
using standard Hazelcast declarative configuration.  The easiest way is to
place a file named "hazelcast-client.xml" in the current working directory
where the application is run.

After initializing the Hazelcast client, the code runs Loader.run() and exits.
