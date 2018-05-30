package us.artit.diseaseplaceholders;

import com.hmmcrunchy.disease.Disease;
import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Main extends PlaceholderExpansion {

    private Disease disease;

    @Override
    public boolean canRegister() {
        return Bukkit.getPluginManager().getPlugin(getPlugin()) != null;
    }

    @Override
    public boolean register() {
        if (!canRegister()) {
            return false;
        }

        disease = (Disease) Bukkit.getPluginManager().getPlugin(getPlugin());

        if (disease == null) {
            return false;
        }
        return PlaceholderAPI.registerPlaceholderHook(getIdentifier(), this);
    }

    @Override
    public String getAuthor() {
        return "Artitus";
    }

    @Override
    public String getIdentifier() {
        return "disease";
    }

    @Override
    public String getPlugin() {
        return "Disease";
    }

    @Override
    public String getVersion() {
        return "0.0.1";
    }

    @Override
    public String onPlaceholderRequest(Player player, String s) {

        if (player == null) {
            return "";
        }

        if (s.equals("disease")) {
            return disease.getDisease(player);
        }

        if (s.equals("sickness")) {
            return String.valueOf(disease.getSickness(player));
        }

        if (s.equals("temperature")) {
            return String.valueOf(disease.getTemperature(player));
        }

        return null;
    }
}
