package me.marti201.nopoppydrop;

import java.io.IOException;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class NoPoppyDrop extends JavaPlugin implements Listener {

	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);

		// MetricsLite (mcstats.org)
		try {
			MetricsLite metrics = new MetricsLite(this);
			metrics.start();
		} catch (IOException ex) {
			getLogger().warning("Error submitting metrics: " + ex.getMessage());
		}
	}

	@EventHandler
	public void onGolemDeath(EntityDeathEvent e) {
		// No need to do anything
		if (e.getEntity().getType() != EntityType.IRON_GOLEM)
			return;

		// Really simple when using Java 8
		e.getDrops().removeIf(is -> is.getType() == Material.RED_ROSE);
	}

}
