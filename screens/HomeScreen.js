import React from "react";
import { render } from "react-dom";
import{
    View,
    Text,
    StyleSheet,
    SafeAreaView,
    TouchableOpacity,
    Image,
    FlatList,
    Touchable

} from "react-native";
import { colours,images,icons,cntSizes,appFonts } from "../constants";


const Main = () => {
    
     //plants for header slide
     const [scannablePlants] = React.useState([
        {   idPlt:0,
            name: "Mango",
            pltImg: images.plant_01,
        },
        {   idPlt:1,
            name: "Guava",
            pltImg: images.plant_02,
        },
        {   idPlt:2,
            name: "Apple",
            pltImg: images.plant_03,
        },
        {   idPlt:3,
            name: "Orange",
            pltImg: images.plant_04,
        },
    ]);


    React.useEffect(() => {
    }, []);

    function renderscannablePlants(item) {
        return (
            <View style={{ alignItems: 'center', justifyContent: 'center', marginHorizontal: cntSizes.baseSpc }}>
                <Image
                  
                    style={{
                        width: cntSizes.width * 0.25,
                        height: '83.5%',
                        borderRadius: 15.2
                    }}  source={item.pltImg}
                    resizeMode="cover"
                />

                <View
                    style={{
                        backgroundColor: colours.green,
                        bottom: '17.25%',
                        right: 0,borderTopLeftRadius: 10,
                        borderBottomLeftRadius: 10,
                        position: 'absolute',
                        paddingObjHorizontal: cntSizes.baseSpc,
                        
                    }}
                >
                    <Text style={{  ...appFonts.bdy3,color: colours.white, }}>{item.name}</Text>
                </View>
            </View>
        )
    }

    return (
        <View style={styles.container}>
            <View style={{ height: "30.25%", backgroundColor: colours.white }}>
                <View style={{
                    flex: 1,
                    borderBottomLeftRadius: 50,
                    borderBottomRightRadius: 50,
                    backgroundColor: colours.green
                }}>
                    <View style={{ marginTop: cntSizes.paddingObj * 2.2, marginHorizontal: cntSizes.paddingObj }}>
                        <View style={{ flexDirection: 'row', alignItems: 'center', justifyContent: 'space-between' }}>
                            <Text style={{ color: colours.white, ...appFonts.h2, }}>Welcome Aayu</Text>
                        </View>
                        <View style={{ marginTop: cntSizes.baseSpc }}>
                            <FlatList
                                horizontal
                                showsHorizontalScrollIndicator={false}
                                data={scannablePlants}
                                keyExtractor={item => item.idPlt.toString()}
                                renderItem={({ item, index }) => renderscannablePlants(item, index)}
                            />
                        </View>
                    </View>
                </View>
            </View>

        </View>
    );
};

//styles for main screen
const styles = StyleSheet.create({
    container:{
    flex:1,
    }
})

export default Main;