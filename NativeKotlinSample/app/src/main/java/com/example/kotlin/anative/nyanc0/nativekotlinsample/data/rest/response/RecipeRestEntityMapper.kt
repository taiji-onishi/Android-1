package com.example.kotlin.anative.nyanc0.nativekotlinsample.data.rest.response

import com.example.kotlin.anative.nyanc0.nativekotlinsample.data.db.entity.RecipeDbEntity
import com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.model.*

/**
 * convert {@link RecipeRestEntity} to {@link RecipeDbEntity}
 */
fun RecipeRestEntity.toRecipeDbEntity(): RecipeDbEntity {
    return RecipeDbEntity(
            recipeId,
            recipeName,
            genreCd,
            genreName,
            introduction,
            imageUrl,
            recommendFlg
    )
}

/**
 * convert List<RecipeRestEntity> to List<RecipeDbEntity>
 */
fun List<RecipeRestEntity>.toRecipeDbEntityList(): List<RecipeDbEntity> = map {
    it.toRecipeDbEntity()
}

/**
 * convert {@link RecipeRestEntity} to {@link Recipe}
 */
fun RecipeRestEntity.toRecipe(): Recipe =
        Recipe(
                recipeId = RecipeId(recipeId),
                recipeName = recipeName,
                genre = Genre(GenreCd(genreCd), genreName),
                introduction = introduction,
                imageUrl = imageUrl,
                recommendFlg = RecommendFlg(recommendFlg)
        )

/**
 * convert List<RecipeRestEntity> to List<Recipe>
 */
fun List<RecipeRestEntity>.toRecipeList(): List<Recipe> = map {
    it.toRecipe()
}