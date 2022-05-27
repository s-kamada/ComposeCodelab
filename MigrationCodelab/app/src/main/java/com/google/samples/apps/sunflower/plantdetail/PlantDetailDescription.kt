/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.sunflower.plantdetail

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.google.samples.apps.sunflower.R
import com.google.samples.apps.sunflower.data.Plant
import com.google.samples.apps.sunflower.viewmodels.PlantDetailViewModel

@Composable
fun PlantDetailDescription(plantDetailViewModel: PlantDetailViewModel) {
    val plant by plantDetailViewModel.plant.observeAsState()

    plant?.let {
        PlantDetailContent(it)
    }
}

@Composable
fun PlantDetailContent(plant: Plant) {
    PlantName(plant.name)
}

@Composable
private fun PlantName(name: String) {
    // <TextView android:id="@+id/plant_detail_name"
    Text(
        text = name,
        style = MaterialTheme.typography.h5,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(id = R.dimen.margin_small))
            .wrapContentWidth(Alignment.CenterHorizontally)
    )
}

@Preview
@Composable
fun PlantDetailContentPreview() {
    val plant = Plant("id", "apple", "description", 3, 30, "")
    MaterialTheme {
        PlantDetailContent(plant)
    }
}

@Preview
@Composable
fun PlantNamePreview() {
    MaterialTheme {
        PlantName("Apple")
    }
}

/** original layout code
<androidx.constraintlayout.widget.ConstraintLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_margin="@dimen/margin_normal">

    <TextView
        android:id="@+id/plant_detail_name"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="@dimen/margin_small"
        android:layout_marginEnd="@dimen/margin_small"
        android:gravity="center_horizontal"
        android:text="@{viewModel.plant.name}"
        android:textAppearance="?attr/textAppearanceHeadline5"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        tools:text="Apple" />

    <TextView
        android:id="@+id/plant_watering_header"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="@dimen/margin_small"
        android:layout_marginTop="@dimen/margin_normal"
        android:layout_marginEnd="@dimen/margin_small"
        android:gravity="center_horizontal"
        android:text="@string/watering_needs_prefix"
        android:textColor="?attr/colorAccent"
        android:textStyle="bold"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/plant_detail_name" />

    <TextView
        android:id="@+id/plant_watering"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="@dimen/margin_small"
        android:layout_marginEnd="@dimen/margin_small"
        android:gravity="center_horizontal"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/plant_watering_header"
        app:wateringText="@{viewModel.plant.wateringInterval}"
        tools:text="every 7 days" />

    <TextView
        android:id="@+id/plant_description"
        style="?android:attr/textAppearanceMedium"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="@dimen/margin_small"
        android:layout_marginTop="@dimen/margin_small"
        android:layout_marginEnd="@dimen/margin_small"
        android:minHeight="@dimen/plant_description_min_height"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/plant_watering"
        app:renderHtml="@{viewModel.plant.description}"
        tools:text="Details about the plant" />

</androidx.constraintlayout.widget.ConstraintLayout>
        */
