package rest.service;


import com.codahale.metrics.health.HealthCheck;

public class UserEntityHealthCheck extends HealthCheck
{
    private final String version;

    public UserEntityHealthCheck(String version)
    {
        this.version = version;
    }

    @Override
    protected Result check() throws Exception
    {
        if (false) {
            return Result.unhealthy("Unhealthy!");
        }

        return Result.healthy("Healthy");
    }
}
