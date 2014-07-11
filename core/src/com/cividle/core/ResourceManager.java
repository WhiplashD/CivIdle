package com.cividle.core;

import com.cividle.CivIdle;
import com.cividle.rsrc.Food;
import com.cividle.rsrc.Herbs;
import com.cividle.rsrc.Land;
import com.cividle.rsrc.Leather;
import com.cividle.rsrc.Metal;
import com.cividle.rsrc.Ore;
import com.cividle.rsrc.Piety;
import com.cividle.rsrc.Research;
import com.cividle.rsrc.Sickness;
import com.cividle.rsrc.Skins;
import com.cividle.rsrc.Stone;
import com.cividle.rsrc.Wood;
import com.cividle.util.Console;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Whiplash
 */
public class ResourceManager extends Trades implements Updateable, Serializable, Invokable, EventCatcher<TradeEvent> {

    private final List<Resource> resourcelist = new ArrayList<>();
    // Basic resources.
    Food food = new Food("Food", "Barn", 1.4f);
    Wood wood = new Wood("Wood", "LumberYard", 1.2f);
    Stone stone = new Stone("Stone", "StoneStockpile", 1.2f);
    // Advanced resources.
    Skins skins = new Skins("Animal Skins", "Storage");
    Herbs herbs = new Herbs("Herbs", "Storage");
    Ore ore = new Ore("Ore", "Storage");
    Leather leather = new Leather("Leather", "Storage");
    Metal metal = new Metal("Metal", "Storage");
    // These special resources have no container.
    Land land = new Land("Land");
    Piety piety = new Piety("Piety", 1.15f);
    Research research = new Research("Research", 1.15f);
    Sickness sickness = new Sickness("Sickness");

    // Variables for gather resources button.
    private final int ClickDefault = 1;
    private double ClickMultiplier = 1.0d;
    private final Random randcollect;

    public ResourceManager() {
        // Add declared resources to the ResourceList and
        // make any special changes to resources here.
        resourcelist.add(food);
        resourcelist.add(wood);
        resourcelist.add(stone);
        resourcelist.add(skins);
        resourcelist.add(herbs);
        resourcelist.add(ore);
        resourcelist.add(leather);
        resourcelist.add(metal);
        resourcelist.add(land);
        resourcelist.add(piety);
        resourcelist.add(research);
        land.setMaxAmount(1000);
        research.setMaxAmount(1000);
        randcollect = new Random();
    }

    public void ClickFood(int value, PopulationManager pm, BuildingManager bm) {
        food.addAmount(((value + ClickDefault) * ClickMultiplier));
        randCollectSpecialResource(pm, bm, food);
    }

    public void ClickWood(int value, PopulationManager pm, BuildingManager bm) {
        wood.addAmount(((value + ClickDefault) * ClickMultiplier));
        randCollectSpecialResource(pm, bm, wood);
    }

    public void ClickStone(int value, PopulationManager pm, BuildingManager bm) {
        stone.addAmount(((value + ClickDefault) * ClickMultiplier));
        randCollectSpecialResource(pm, bm, stone);
    }

    private void GatherFood(PopulationManager pm) { // Farm Farmer
        food.addAmount(((pm.farmer.getAmount()) * food.getGatherMultiplier()));
    }

    public String DispFPS(PopulationManager pm) {
        return " (" + CivIdle.pdr.FormatDecimalFormat((pm.farmer.getAmount() * food.getGatherMultiplier() - pm.getPopulationAmount())) + "/s)";
    }

    private void GatherWood(PopulationManager pm) { // Forester
        wood.addAmount(((pm.forester.getAmount()) * wood.getGatherMultiplier()));
    }

    public String DispWPS(PopulationManager pm) {
        return " (" + CivIdle.pdr.FormatDecimalFormat(pm.forester.getAmount() * wood.getGatherMultiplier()) + "/s)";
    }

    private void GatherStone(PopulationManager pm) { // Miner
        stone.addAmount(((pm.miner.getAmount()) * stone.getGatherMultiplier()));
    }

    public String DispSPS(PopulationManager pm) {
        return " (" + CivIdle.pdr.FormatDecimalFormat(pm.miner.getAmount() * stone.getGatherMultiplier()) + "/s)";
    }

    private void GatherHerbs(PopulationManager pm, BuildingManager bm) { // Greenhouse Gardener
        herbs.addAmount(pm.gardner.getAmount() * herbs.getGatherMultiplier());
        UpdateSharedResourceLimit(bm.storagestockpile);
    }

    private void GatherSkins(PopulationManager pm, BuildingManager bm) { // Hunting Lodge Hunter
        skins.addAmount((pm.hunter.getAmount() * skins.getGatherMultiplier()));
        UpdateSharedResourceLimit(bm.storagestockpile);
    }

    private void ConvertSkinsToLeather(PopulationManager pm, BuildingManager bm) { // Tannery Tanner
        if (skins.getAmount() > 0 && !leather.limitReached()) {
            skins.subtractAmount(pm.tanner.getAmount());
            leather.addAmount(pm.tanner.getAmount());
        }
    }

    private void ConertOreToMetal(PopulationManager pm, BuildingManager bm) { // Smithey Blacksmith
        if (ore.getAmount() > 0 && !metal.limitReached()) {
            ore.subtractAmount(pm.blacksmith.getAmount());
            metal.addAmount(pm.blacksmith.getAmount());
        }
    }

    private void GenerateResearch(BuildingManager bm, PopulationManager pm) { // School
        research.addAmount(bm.school.getAmount() * (pm.getPopulationAmount() * 0.075) * research.getGatherMultiplier());
    }

    private void GeneratePiety(PopulationManager pm) { // Church Cleric
        piety.addAmount(pm.cleric.getAmount() * piety.getGatherMultiplier());
    }

    private void GenerateSickness(PopulationManager pm) { // Unburied dead generate sickness.
        sickness.addAmount(pm.unburieddead.getAmount() * sickness.getGatherMultiplier());
    }

    private void randCollectSpecialResource(PopulationManager pm, BuildingManager bm, Resource r) { // Helps make clicking relevant.
        int temprand = randcollect.nextInt(1000);
        if (temprand > 40 && temprand < 80) { // If in 8% range.
            switch (r.getName()) {
                case "Food":
                    skins.addAmount(1 + ((pm.getPopulationAmount() + (pm.forester.getAmount() / 50)) / 50));
                    break;
                case "Wood":
                    herbs.addAmount(1 + ((pm.getPopulationAmount() + (pm.farmer.getAmount() / 50)) / 50));
                    break;
                case "Stone":
                    ore.addAmount(1 + ((pm.getPopulationAmount() + (pm.miner.getAmount() / 50)) / 50));
                    break;
            }
            UpdateSharedResourceLimit(bm.storagestockpile);
        } else if (temprand > 15 && temprand < 40) { // If in 4% range.
            switch (r.getName()) {
                case "Food":
                    skins.addAmount(1 + ((pm.getPopulationAmount() + (pm.forester.getAmount() / 20)) / 20));
                    break;
                case "Wood":
                    herbs.addAmount(1 + ((pm.getPopulationAmount() + (pm.farmer.getAmount() / 20)) / 20));
                    break;
                case "Stone":
                    ore.addAmount(1 + ((pm.getPopulationAmount() + (pm.miner.getAmount() / 20)) / 20));
                    break;
            }
            UpdateSharedResourceLimit(bm.storagestockpile);
        } else if (temprand <= 15) { // If in 1.5% range.
            switch (r.getName()) {
                case "Food":
                    skins.addAmount(1 + ((pm.getPopulationAmount() + (pm.forester.getAmount() / 4)) / 4));
                    break;
                case "Wood":
                    herbs.addAmount(1 + ((pm.getPopulationAmount() + (pm.farmer.getAmount() / 4)) / 4));
                    break;
                case "Stone":
                    ore.addAmount(1 + ((pm.getPopulationAmount() + (pm.miner.getAmount() / 4)) / 4));
                    break;
            }
            UpdateSharedResourceLimit(bm.storagestockpile);
        }

    }

    /**
     * Pays (removes) resources to buy something.
     *
     * @param values the double[] to be used.
     */
    public void PayResources(Double[] values) {
        wood.subtractAmount(values[0]);
        stone.subtractAmount(values[1]);
        metal.subtractAmount(values[2]);
        skins.subtractAmount(values[3]);
        herbs.subtractAmount(values[4]);
        leather.subtractAmount(values[5]);
        piety.subtractAmount(values[6]);
        land.addAmount(values[7]);
    }

    /**
     * Refunds (adds) resources to sell something.
     *
     * @param values the double[] to be used.
     */
    public void RefundResources(Double[] values) {
        wood.addAmount(values[0]);
        stone.addAmount(values[1]);
        metal.addAmount(values[2]);
        skins.addAmount(values[3]);
        herbs.addAmount(values[4]);
        leather.addAmount(values[5]);
        piety.addAmount(values[6]);
        land.subtractAmount(values[7]);
    }

    /**
     * Updates the limit of resources that can be stored in building b.
     *
     * @param b the container building.
     */
    public void UpdateResourceLimit(Building b) {
        Console.println("Updating resource limit.");
        switch (b.getName()) {
            case "Barn":
                food.setMaxAmount((b.getAmount() * b.getCapacity()));
                break;
            case "LumberYard":
                wood.setMaxAmount((b.getAmount() * b.getCapacity()));
                break;
            case "StoneStockpile":
                stone.setMaxAmount((b.getAmount() * b.getCapacity()));
                break;
            case "Storage":
                UpdateSharedResourceLimit(b);
                break;
        }
    }

    private void UpdateSharedResourceLimit(Building b) {
        double tmp = (b.getAmount() * b.getCapacity()) - (skins.getAmount() + herbs.getAmount() + ore.getAmount() + leather.getAmount() + metal.getAmount());
        skins.setMaxAmount(tmp);
        herbs.setMaxAmount(tmp);
        ore.setMaxAmount(tmp);
        leather.setMaxAmount(tmp);
        metal.setMaxAmount(tmp);
    }

    /**
     *
     * @param b
     * @return the amount of all resources that are held in storage added
     * together.
     */
    public double GetSharedAmount(Building b) {
        double tmp = (skins.getAmount() + herbs.getAmount() + ore.getAmount() + leather.getAmount() + metal.getAmount());
        return tmp;
    }

    /**
     * Updates the click multiplier value.
     *
     * @param pm the population manager.
     * @param multiplier resource dependent multiplier.
     */
    public void ClickMultiplierUpdater(PopulationManager pm, float multiplier) {
        // ClickMultiplier = a base of 1 plus a base .1 percent plus .1 percent for each person in the population.
        // Will probably need to be tweaked later.
        ClickMultiplier = ((pm.getPopulationAmount() * 0.001f) + 0.001f) * multiplier + 1;

    }

    @Override
    public void CatchEvent(TradeEvent ev) {
        Console.println("Caught trade event.");
    }

    @Override
    public void Update(Game game) {
        GatherFood(game.pm);
        GatherWood(game.pm);
        GatherStone(game.pm);
        GatherHerbs(game.pm, game.bm);
        GatherSkins(game.pm, game.bm);
        ConvertSkinsToLeather(game.pm, game.bm);
        ConertOreToMetal(game.pm, game.bm);
        GenerateResearch(game.bm, game.pm);
        GeneratePiety(game.pm);
        GenerateSickness(game.pm);
    }

    @Override
    public void execute(String command) {
        String[] tmp = command.split(delimiter);
        try {
            switch (tmp[1]) {
                case "help":
                    Console.println("Usage: rm.[resource identifier].[resource command]");
                    break;
                default:
                    for (Resource r : resourcelist) {
                        if (r.getName().toLowerCase().equals(tmp[1])) {
                            r.execute(command);
                            return;
                        }
                    }
                    Console.println("Invalid command.");
                    Console.println(" @" + this.getClass().getName());
            }
        } catch (IndexOutOfBoundsException e) {
            Console.println("Invalid command.");
            Console.println(" @" + this.getClass().getName());
        }
    }
}
