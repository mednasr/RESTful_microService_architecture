package rest.service;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import rest.resources.UserResource;

public class UserEntityService extends Application<UserEntityConfig>
{
    @Override
    public void run(UserEntityConfig config, Environment environment) throws Exception
    {
        final UserResource personService = new UserResource();
        environment.jersey().register(personService);

        final UserEntityHealthCheck healthCheck = new UserEntityHealthCheck(config.getVersion());
        environment.healthChecks().register("user", healthCheck);
        environment.jersey().register(healthCheck);
    }
}
