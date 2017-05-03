/*
 * Copyright 2017 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.wildAnimals.WorldlyTooltipDisplay;

import org.terasology.entitySystem.entity.EntityRef;
import org.terasology.entitySystem.event.ReceiveEvent;
import org.terasology.entitySystem.systems.BaseComponentSystem;
import org.terasology.entitySystem.systems.RegisterMode;
import org.terasology.entitySystem.systems.RegisterSystem;
import org.terasology.logic.common.DisplayNameComponent;
import org.terasology.rendering.nui.layers.ingame.inventory.GetItemTooltip;
import org.terasology.rendering.nui.widgets.TooltipLine;
import org.terasology.wildAnimals.component.WildAnimalComponent;
import org.terasology.worldlyTooltip.events.GetTooltipIconEvent;
import org.terasology.worldlyTooltip.events.GetTooltipNameEvent;

@RegisterSystem(value = RegisterMode.CLIENT, requiresOptional = {"WorldlyTooltip"})
public class WildAnimalsTooltipSystem extends BaseComponentSystem {

    /*
     * Sets the Name at the top of the WorldlyTooltip to show the animal name
     */
    @ReceiveEvent
    public void getTooltipName(GetTooltipNameEvent event, EntityRef entity, WildAnimalComponent wildAnimalComponent) {
        event.setName(wildAnimalComponent.name);
    }

    /*
     * Adds the Name inside WorldlyTooltip to show the DisplayName generated by the RandomNameGenerator
     */
    @ReceiveEvent
    public void addDisplayNameToTooltip(GetItemTooltip event, EntityRef entity, DisplayNameComponent displayNameComponent, WildAnimalComponent wildAnimalComponent) {
        event.getTooltipLines().add(new TooltipLine("Name: " + displayNameComponent.name));
    }

    /*
     * Adds the Icon to the WorldlyTooltip to show the corresponding WildAnimal's icon
     */
    @ReceiveEvent
    public void addIconToWorldlyTooltip(GetTooltipIconEvent event, EntityRef entity, WildAnimalComponent wildAnimalComponent) {
        event.setIcon(wildAnimalComponent.icon);
    }

}