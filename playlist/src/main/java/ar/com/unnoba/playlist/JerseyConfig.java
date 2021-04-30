package ar.com.unnoba.playlist;


import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import ar.com.unnoba.playlist.resources.SongResource;

/**
 *
 * @author jpgm
 */
@Component
public class JerseyConfig extends ResourceConfig
{
    public JerseyConfig() 
    {
        register(SongResource.class);
    }
}
