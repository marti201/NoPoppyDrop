package me.marti201.nopoppydrop;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class NoPoppyDrop extends JavaPlugin implements Listener {

	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
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
