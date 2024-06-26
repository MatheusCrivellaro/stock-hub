import './CardVehicle.css'

const CardVehicle = ({ vehicle }) => {
    return (
        <div>
            <div className="card">
                {vehicle.fotos.foto.map(
                    foto => (
                        <img src={foto.URI} className="card-img-top" alt="..."/>
                    )
                )}
                <div className="card-body">
                    <p className="card-text">Some quick example text to build on the card title and make up the bulk of
                        the card's content.</p>
                </div>
            </div>
        </div>
    )
}

export default CardVehicle