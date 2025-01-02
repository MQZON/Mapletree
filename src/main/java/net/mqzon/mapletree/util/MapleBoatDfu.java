package net.mqzon.mapletree.util;

import com.terraformersmc.terraform.boat.api.data.TerraformBoatDfuApi;

import java.util.Collection;
import java.util.Set;

public class MapleBoatDfu implements TerraformBoatDfuApi {
    @Override
    public Collection<String> getDfuBoatIds() {
        return Set.of("mapletree:maple_boat", "mapletree:maple_chest_boat");
    }
}