package vb.$howtomakerecipe;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.event.*;
import org.bukkit.plugin.java.*;

public class PluginMain extends JavaPlugin implements Listener {

	private static PluginMain instance;

	@Override
	public void onEnable() {
		instance = this;
		getServer().getPluginManager().registerEvents(this, this);
		try {
			Object $66c620e56c3faf40a753768c870efe4d = null;
			$66c620e56c3faf40a753768c870efe4d = new org.bukkit.inventory.ShapedRecipe(
					new org.bukkit.NamespacedKey(((org.bukkit.plugin.Plugin) (Object) PluginMain.getInstance()),
							"xp_bottle"),
					new org.bukkit.inventory.ItemStack(PluginMain.getNamedItemWithLore(
							((org.bukkit.Material) org.bukkit.Material.EXPERIENCE_BOTTLE),
							ChatColor.translateAlternateColorCodes('&', "&2op sword"),
							new ArrayList(Arrays.asList("get a op sword")))));
			((org.bukkit.inventory.ShapedRecipe) (Object) $66c620e56c3faf40a753768c870efe4d)
					.shape(((java.lang.String[]) new ArrayList(Arrays.asList("zbz", "zbz", "zaz"))
							.toArray(new java.lang.String[]{})));
			((org.bukkit.inventory.ShapedRecipe) (Object) $66c620e56c3faf40a753768c870efe4d)
					.setIngredient("b".charAt(0), ((org.bukkit.Material) org.bukkit.Material.DIAMOND_BLOCK));
			((org.bukkit.inventory.ShapedRecipe) (Object) $66c620e56c3faf40a753768c870efe4d)
					.setIngredient("a".charAt(0), ((org.bukkit.Material) org.bukkit.Material.STICK));
			org.bukkit.Bukkit.addRecipe(((org.bukkit.inventory.Recipe) (Object) $66c620e56c3faf40a753768c870efe4d));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onDisable() {
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String label, String[] commandArgs) {
		return true;
	}

	public static void procedure(String procedure, List procedureArgs) throws Exception {
	}

	public static Object function(String function, List functionArgs) throws Exception {
		return null;
	}

	public static List createList(Object obj) {
		if (obj instanceof List) {
			return (List) obj;
		}
		List list = new ArrayList<>();
		if (obj.getClass().isArray()) {
			int length = java.lang.reflect.Array.getLength(obj);
			for (int i = 0; i < length; i++) {
				list.add(java.lang.reflect.Array.get(obj, i));
			}
		} else if (obj instanceof Collection<?>) {
			list.addAll((Collection<?>) obj);
		} else if (obj instanceof Iterator) {
			((Iterator<?>) obj).forEachRemaining(list::add);
		} else {
			list.add(obj);
		}
		return list;
	}

	public static void createResourceFile(String path) {
		Path file = getInstance().getDataFolder().toPath().resolve(path);
		if (Files.notExists(file)) {
			try (InputStream inputStream = PluginMain.class.getResourceAsStream("/" + path)) {
				Files.createDirectories(file.getParent());
				Files.copy(inputStream, file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static PluginMain getInstance() {
		return instance;
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void event1(org.bukkit.event.player.PlayerInteractEvent event) throws Exception {
		Object $acacc264cd4e0aedf62e92bfb7a0b5ed = null;
		if (PluginMain.checkEquals(((org.bukkit.inventory.ItemStack) event.getItem()),
				new org.bukkit.inventory.ItemStack(
						PluginMain.getNamedItemWithLore(((org.bukkit.Material) org.bukkit.Material.EXPERIENCE_BOTTLE),
								ChatColor.translateAlternateColorCodes('&', "&2op sword"),
								new ArrayList(Arrays.asList("get a op sword")))))) {
			if ((PluginMain.checkEquals(((org.bukkit.event.block.Action) event.getAction()),
					((org.bukkit.event.block.Action) org.bukkit.event.block.Action.RIGHT_CLICK_AIR))
					|| PluginMain.checkEquals(((org.bukkit.event.block.Action) event.getAction()),
							((org.bukkit.event.block.Action) org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK)))) {
				$acacc264cd4e0aedf62e92bfb7a0b5ed = new org.bukkit.inventory.ItemStack(
						PluginMain.getNamedItemWithLore(((org.bukkit.Material) org.bukkit.Material.DIAMOND_SWORD),
								ChatColor.translateAlternateColorCodes('&', "&2killer_sharp"),
								new ArrayList(Arrays.asList("get killed in 1 hehe"))));
				((org.bukkit.inventory.ItemStack) (Object) $acacc264cd4e0aedf62e92bfb7a0b5ed).addUnsafeEnchantment(
						((org.bukkit.enchantments.Enchantment) org.bukkit.enchantments.Enchantment.DAMAGE_ALL),
						((int) (10d)));
				((org.bukkit.World) ((org.bukkit.entity.Entity) (Object) ((org.bukkit.entity.Player) event.getPlayer()))
						.getWorld()).dropItem(
								((org.bukkit.Location) ((org.bukkit.entity.Entity) (Object) ((org.bukkit.entity.Player) event
										.getPlayer())).getLocation()),
								((org.bukkit.inventory.ItemStack) (Object) $acacc264cd4e0aedf62e92bfb7a0b5ed));
			}
		}
	}

	public static org.bukkit.inventory.ItemStack getNamedItemWithLore(Material material, String name,
			List<String> lore) {
		org.bukkit.inventory.ItemStack item = new org.bukkit.inventory.ItemStack(material);
		org.bukkit.inventory.meta.ItemMeta itemMeta = item.getItemMeta();
		if (itemMeta != null) {
			itemMeta.setDisplayName(name);
			itemMeta.setLore(lore);
			item.setItemMeta(itemMeta);
		}
		return item;
	}

	public static boolean checkEquals(Object o1, Object o2) {
		if (o1 == null || o2 == null) {
			return false;
		}
		return o1 instanceof Number && o2 instanceof Number
				? ((Number) o1).doubleValue() == ((Number) o2).doubleValue()
				: o1.equals(o2);
	}
}
