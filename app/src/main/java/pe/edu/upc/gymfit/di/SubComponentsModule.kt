package pe.edu.upc.gymfit.di

import pe.edu.upc.gymfit.di.auth.AuthComponent
import pe.edu.upc.gymfit.di.main.MainComponent
import dagger.Module

@Module(
    subcomponents = [
        AuthComponent::class,
        MainComponent::class
    ]
)
class SubComponentsModule