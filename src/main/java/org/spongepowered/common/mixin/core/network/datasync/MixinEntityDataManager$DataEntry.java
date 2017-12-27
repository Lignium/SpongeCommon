/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.common.mixin.core.network.datasync;

import net.minecraft.network.datasync.EntityDataManager;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.common.interfaces.network.datasync.IMixinEntityDataManager$DataEntry;
import org.spongepowered.common.registry.type.data.KeyRegistryModule;

import java.util.Optional;

import javax.annotation.Nullable;

@Mixin(EntityDataManager.DataEntry.class)
public abstract class MixinEntityDataManager$DataEntry implements IMixinEntityDataManager$DataEntry {

    @Nullable Key<?> relatedKey = KeyRegistryModule.getInstance().getKeyFromDataEntry();

    @Override
    public Optional<Key<?>> getRelatedKey() {

        return Optional.empty();
    }

    @Override
    public <T> ImmutableValue<T> createValue(T currentValue) {
        return null;
    }

    @Override
    public <T> T getValueFromEvent(ImmutableValue<?> immutableValue) {
        return null;
    }
}
