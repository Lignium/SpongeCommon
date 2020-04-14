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
package org.spongepowered.common.text.format;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import net.minecraft.util.registry.SimpleRegistry;
import net.minecraft.util.text.TextFormatting;
import org.spongepowered.api.CatalogKey;
import org.spongepowered.api.text.format.TextStyle;
import org.spongepowered.api.text.format.TextStyles;
import org.spongepowered.common.SpongeImpl;
import org.spongepowered.common.registry.MappedRegistry;

public final class SpongeTextStyleType extends SpongeTextStyle implements TextStyle.Type {

    public static SpongeTextStyleType of(TextFormatting formatting) {
        final SimpleRegistry<TextStyle.Type> registry = SpongeImpl.getRegistry().getCatalogRegistry().getRegistry(TextStyle.Type.class);
        TextStyle.Type style = ((MappedRegistry<TextStyle.Type, TextFormatting>) registry).getReverseMapping(formatting);
        if (style == null) {
            style = TextStyles.RESET.get();
        }

        return (SpongeTextStyleType) style;
    }

    private final CatalogKey key;

    public SpongeTextStyleType(CatalogKey key, TextFormatting handle) {
        super(handle);
        this.key = checkNotNull(key);
    }

    @Override
    public CatalogKey getKey() {
        return this.key;
    }

    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SpongeTextStyleType)) {
            return false;
        }

        final SpongeTextStyleType that = (SpongeTextStyleType) o;

        return this.key.equals(that.key);
    }

    @Override
    public int hashCode() {
        return this.key.hashCode();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(SpongeTextStyle.class)
            .add("key", this.key)
            .toString();
    }
}